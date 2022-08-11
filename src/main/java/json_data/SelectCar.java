package json_data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectCar {
    @SerializedName("make")
    private String make;

    @SerializedName("model")
    private String model;

    @SerializedName("year")
    private String year;

    @SerializedName("body_type")
    private String bodyType;

    @SerializedName("transmission")
    private String transmission;

    @SerializedName("fuel_type")
    private String fuelType;

    @SerializedName("variant")
    private String variant;

    @SerializedName("series")
    private String series;
}
