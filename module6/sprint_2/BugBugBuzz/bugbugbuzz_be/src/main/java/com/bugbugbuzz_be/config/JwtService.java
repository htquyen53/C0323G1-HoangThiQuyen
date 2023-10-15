package com.bugbugbuzz_be.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;
//    @Value("${jwt.token-expiration}")
    private long jwtExpiration = 60*60*24*1000;
//    @Value("${jwt.refresh-token.expiration}")
    private long refreshExpiration = 60*60*24*1000;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Phương thức extractUsername với kiểu dl trả về là String và nhận 1 tham số là 1 chuỗi token
     * extractClaim(token, Claims:getSubject) được gọi và truyền 2 tham số token và 1 đối tượng hàm (function Interface)
     * Claims:getSubject là một tham chiếu đến phương thức getSubject của đối tượng Claims, dùng để trích xuất thông tin về người dùng từ các claims của token
     * extractClaim: là một phương thức chung => nhận 1 chuỗi token và 1 đối tượng hàm để xử lý claim cụ thể
     * Kết quả trả về của phương thức trên là tên người dùng (username) được trích xuất từ token
     */

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Mục đích của method extractClaim: trích xuất thông tin từ token bằng cách sử dụng một dối tượng hàm để xử lý claim cụ thể
     * final Claims claims = extractAllClaims(token): trích xuất tất cả các thông tin (claims) từ token và lưu trữ trong một đối tượng Claims (được khai báo là final để bảo đảm rằng nó không thay đổi).
     * claimsResolver là một đối tượng hàm được sử dụng để xử lý claim cụ thể từ Claims, khi thực hiện phương thức apply(), đối tượng claim đã truyền vào sẽ được xử lý theo logic đã được định nghĩa trong hàm, và trả về một giá trị kiểu T
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * MĐ: Tạo một chuỗi token dựa trên thông tin người dùng (userDetails)
     * Tham số đầu vào: một ối tượng userDetails (UserDetails)
     * generateToken(new HashMap<>(), userDetails): tham số thứ nhất thể hiện thông tin claim bạn muốn truyền vào token, tham số thứ 2 là đối tượng userDetail chứa thông tin ngời dùng mà bạn muốn đứa vào token
     * Return: Chuỗi token tự tạo
     */
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails) {
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    public String generateRefreshToken(
            UserDetails userDetails
    ) {
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
    }

    /**
     * Refresh Token => cung cấp tín năng tái xác thực, duy trì phiên làm việc của người dùng trong một khoảng thời gian dài hơn.
     * Cụ thể:
            * Khi người dùng login và xác thực thành công, hệ thống sẽ cung cấp cho user một cặp token bao gồm access token và refresh token.
            * Access token => là một chuỗi token ngắn hạn, dùng để xác thực và truy cập tài nguyên bảo mật trên hệ thống, tuy nhiên thời hạn hợp lệ ngắn, thường chỉ trong vài phút hoặc vài giờ
            * Jgu access token hết hạn, người dùng không không thể sử dụng nó để truy cập tài nguyên nữa => refresh token yêu cầu một access token mời từ hệ thống, refresh token có thời hạn hợp lệ lâu hơn access token, thường từ vài ngày đến vài tuần
     * Lợi ích:
            * Giúp user không cần phải đăng nhập lại sau khi access token hết hạn, mà chỉ cần thực hiện yêu cầu tái xác thực bằng cách gửi refresh lên hệ thống.
            * Tăng tính bảo mật cho hệ thống, tránh việc đăng nhập quá thường xuyên
     */

    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    /**
     * MĐ: Đây là khai báo của một phương thức getSignInKey có kiểu dữ liệu trả về là Key.
     *
     * byte[] keyBytes = Decoders.BASE64.decode(secretKey): Chuỗi secretKey được giải mã từ base64 thành một mảng
     * byte bằng cách sử dụng phương thức decode của lớp Decoders trong phiên bản mã hóa base64.
     *
     * return Keys.hmacShaKeyFor(keyBytes): Mảng byte keyBytes được sử dụng để tạo một khóa ký (signing key) bằng
     * cách sử dụng phương thức hmacShaKeyFor của lớp Keys. Phương thức này tạo ra một khóa ký HMAC-SHA cho việc
     * ký hiệu (signing) chuỗi token.
     */
}
