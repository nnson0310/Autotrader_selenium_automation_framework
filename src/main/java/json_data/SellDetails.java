package json_data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellDetails {

    @SerializedName("expired")
    private String expired;

    @SerializedName("registration_vin")
    private RegistrationVin registrationVin;

    @SerializedName("expiry_date")
    private ExpiryDate expiryDate;

    @SerializedName("car_specifics")
    private CarSpecifics carSpecifics;

    @SerializedName("additional")
    private Additional additional;

    @Getter
    @Setter
    public static class RegistrationVin {
        @SerializedName("number_plate")
        private String numberPlate;

        @SerializedName("vin")
        private String vin;
    }

    @Getter
    @Setter
    public static class ExpiryDate {
        @SerializedName("month")
        private String month;

        @SerializedName("year")
        private String year;
    }

    @Getter
    @Setter
    public static class CarSpecifics {
        @SerializedName("asking_price")
        private String askingPrice;

        @SerializedName("odometer_reading")
        private String odometerReading;

        @SerializedName("pickup_location_input")
        private String pickupLocationInput;

        @SerializedName("pickup_location_select")
        private String pickupLocationSelect;

        @SerializedName("exterior_colour")
        private String exteriorColour;

        @SerializedName("interior_colour")
        private String interiorColour;
    }

    @Getter
    @Setter
    public static class Additional {
        @SerializedName("logbook")
        private String logbook;

        @SerializedName("set_keys")
        private String setKeys;
    }
}
