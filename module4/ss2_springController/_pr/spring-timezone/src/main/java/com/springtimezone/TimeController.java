package com.springtimezone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
@GetMapping("/work-clock")
public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh")String city) {
    // Lấy ra thời gian cụ thẻ
    Date date = new Date();
    // Lấy ra timezone hiện tại
    TimeZone local = TimeZone.getDefault();
    // Lấy ra timezone của một tp cụ thể.
    TimeZone locale = TimeZone.getTimeZone(city);
    // Tính thời gian hiện tại của một thành phố cụ thể
    long locale_time = date.getTime() + (locale.getRawOffset());
    // Cài đặt lại thời gian cho biến date thành thời gian hiê tại của 1 tp cụ thể.
    date.setTime(locale_time);
    // Chuyển dữ liệu và gửi qua view
    model.addAttribute("city",city);
    model.addAttribute("date",date);
    return "/index";
}
}
