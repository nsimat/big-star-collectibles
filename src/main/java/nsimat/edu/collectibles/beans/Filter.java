package nsimat.edu.collectibles.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Filter {

    private List<String> productType;
    private List<String> selectedType;

    public Filter(){
        this.productType = Arrays.asList("ALL", "HAT", "MUG", "BAG", "SHIRT", "ARTWORK", "PILLOW", "APRON", "NOTEBOOK", "CARD");
    }
}
