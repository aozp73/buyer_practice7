package shop.mtcoding.buyer9.dateUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateFormat {

    public static String dateFormatter(Timestamp stamp) {
        LocalDateTime resTime = stamp.toLocalDateTime();
        String res = resTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return res;
    }

}
