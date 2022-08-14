package json_data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToFavourite {

    @SerializedName("featured_searches")
    private String featuredSearches;

    @SerializedName("cars")
    private FavouriteCar favouriteCar;

    @SerializedName("expected_notify")
    private String expectedNotify;

    @Setter
    @Getter
    public static class FavouriteCar {

        private int count = 0;

        public FavouriteCar() {
            count++;
        }

        @SerializedName("name")
        private String name;

        @SerializedName("price")
        private String price;

        @SerializedName("odometer_reading")
        private String odometerReading;
    }
}
