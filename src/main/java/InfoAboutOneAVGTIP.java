import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Data
@NoArgsConstructor
public class InfoAboutOneAVGTIP {
    private String time_of_day;
    private String trip_distance;
    private String payment_type;
    private String tip_amount;

    @Override
    public String toString() {
        return "InfoAboutOneAVGTIP{" +
                "time_of_day='" + time_of_day + '\'' +
                ", trip_distance='" + trip_distance + '\'' +
                ", payment_type='" + payment_type + '\'' +
                ", tip_amount='" + tip_amount + '\'' +
                '}';
    }

    public String getTime_of_day() {
        return time_of_day;
    }

    public void setTime_of_day(String time_of_day) {
        this.time_of_day = time_of_day;
    }

    public String getTrip_distance() {
        return trip_distance;
    }

    public void setTrip_distance(String trip_distance) {
        this.trip_distance = trip_distance;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getTip_amount() {
        return tip_amount;
    }

    public void setTip_amount(String tip_amount) {
        this.tip_amount = tip_amount;
    }

    public InfoAboutOneAVGTIP(String tpep_pickup_datetime, String trip_distance, String payment_type, String tip_amount) {
        SimpleDateFormat formatPattern = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// creating new date format that .csv files using

        try {
            Date date = formatPattern.parse(tpep_pickup_datetime);
            Calendar calendar = GregorianCalendar.getInstance();// creating calendar for reading hours
            calendar.setTime(date);
            int hours = calendar.get(Calendar.HOUR_OF_DAY);// reading hours
            if(hours >=5 && hours <= 12){
                this.time_of_day = "[Morning]";
            } else if(hours > 12 && hours <= 17){
                this.time_of_day = "[Afternoon]";
            } else if(hours > 17 && hours <= 21){
                this.time_of_day = "[Evening]";
            } else {
                this.time_of_day = "[Night]";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.trip_distance = trip_distance;
        this.payment_type = payment_type;
        this.tip_amount = tip_amount;
    }
}
