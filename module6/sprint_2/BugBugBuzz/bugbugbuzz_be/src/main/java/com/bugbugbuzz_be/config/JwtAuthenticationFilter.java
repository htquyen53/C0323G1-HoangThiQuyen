package com.bugbugbuzz_be.config;

import com.bugbugbuzz_be.repository.token.TokenRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
//        if(request.getServletPath().contains("/api/v1/auth")) {
//            filterChain.doFilter(request,response);
//            return;
//        }
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("____________________________No JWT Header");
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        System.out.println(jwt);
        username = jwtService.extractUsername(jwt); //extract username
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean isTokenValid = tokenRepository.findAllByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked()).orElse(false);
            /**
             * => Xuống DB kiểm tra tính hợp lệ của token, nếu token có trong DB và không hết hạn cũng như không bị thu hồi thì trả về giá trị true
             */
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                /**
                 *  MĐ: Thiết lập thông tin chi tiết về xác thực trong đối tượng authToken;
                 *  phương thức setDetails() được gọi trên đối tượng authToken,  và new WebAuthenticationDetailsSource().buildetails(requets)
                 *  => tạo đối tượng WebAuthenticationDetails chứa thông tin chi tiết về xác thực từ yêu cầu (request)
                 *  Thông tin này bao gồm: địa chỉ IP của Client, cổng và các thông tin khác liên quan đến yc HTTP
                 *  Phương thức buildDetails(request) được sử dụng để xây dựng đối tượng WebAuticationDetailsSource từ yêu cầu request hiện tại
                 *  Sau đó, authToken được sử dụng để chuyển tiếp thông tin xác thực trong quá trình xử lý request, vd thông qua AuthenticationManager của Spring Security để
                 *  xác thực người dùng và cấp phát phiên hoặc token xác thực
                 */
                SecurityContextHolder.getContext().setAuthentication(authToken);
                /**
                 * SecurityContextHolder là một lớp trong Spring Security, được sử dụng để lưu trữ và quản lý thông tin về người dùng đã được
                 * xác thực trong quá trình xử lý yêu cầu của ứng dụng.
                 * SecurityContextHolder cung cấp một cách tiện lợi để truy cập thông tin xác thực của người dùng hiện tại mà không cần truyền
                 * thông qua các tham số trong các phương thức. Nó sử dụng cơ chế lưu trữ theo luồng (thread-local storage) để đảm bảo rằng thông tin xác thực chỉ được truy cập bởi luồng đang thực thi yêu cầu tương ứng.
                 */
            }
        }
        System.out.println("____________________________Authenticated");
        filterChain.doFilter(request, response);
        /**
         * MĐ: Chuyển tiếp yêu cầu và phản hooif đến bộ lọc tiếp theo trong chuỗi bộ lọc, cho phép các bộ lọc khác tiếp tục xử lý yu càu hoặc phản hồi
         * trước khi nó đến servlet chính hoặc kết thúc xử lý yêu cầu.
         */
    }
}
