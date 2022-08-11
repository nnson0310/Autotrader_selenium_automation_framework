package json_data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SellFeatures {

    @SerializedName("optional_extras")
    private List<String> optionalExtras;

    @SerializedName("custom_modifications")
    private List<String> customModifications;

    @SerializedName("description")
    private String description;
}
