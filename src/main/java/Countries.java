import lombok.Data;

import java.util.List;

@Data
public class Countries {

        String name = "";
        List TopLevelDomain;
        String alpha2Code= "";
        String alpha3Code =  "";
        List callingCodes ;
        String capital = "";
        List altSpellings;
        String region = "";
        String subregion = "";
        int population = 0;
        List latlng;
        String demonym = "";
        int area = 0;
        int gini = 0;
        List timezones;
        List borders;
        String nativeName = "";
        String numericCode = "";
        List <CurrenciesItems> currencies;

}
@Data
class CurrenciesItems{
    String code = "";
    String name = "";
    String symbol = "";
}


