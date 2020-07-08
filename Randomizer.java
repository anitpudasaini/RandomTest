@WebService
public class Randomizer{

    @WebMethod(action="address")
    public RAddress address(){
        int house = (int)(Math.random()*9999);
        String[] streets = getStreets();
        String street = streets[(int)(Math.random()*streets.length)];
        int[] postalCodes = getPostalCodes();
        int postalCode = postalCodes[(int)(Math.random()*postalCodes.length)];
        String[] cities = getCities();
        String city = cities[(int)(Math.random()*cities.length)];
        Country country = Country.values()[(int)(4*Math.random())];
        String localCountry = getLocalCountryName(country);
        int countryCode = getCountryCode(country);
        String[] states = getStates(country);
        String state = states[(int)(Math.random()*states.length)];
        return new RAddress(house, street, postalCode, city, country, state);
    }
    enum Country{US,Canada,Mexico,Netherlands};
    public class RAddress{
        private int house;
        private String street;
        private int postalCode;
        private String city;
        private String county;
        private Country country;
        private String state;
        private String stateCode;
        private String localCountry;
        private String countryCode;

        public RAddress(int house, String street, int postalCode, String city, Country country
        , String state, String county, String stateCode, String localCountry, String countryCode){
            this.house = house;
            this.street = street;
            this.postalCode = postalCode;
            this.city = city;
            this.country = country;
            this.state = state;
            this.stateCode = stateCode;
            this.localCountry = localCountry;
            this.countryCode = countryCode;
            this.county = county;
        }

        public RAddress(int house, String street, int postalCode, String city, Country country
        , String state){
            this(house, street, postalCode, city, country, state, "", "", "", "");
        }
    }

    public String[] getStreets(){
        return new String[]{"main st","first st"};
    }

    public String[] getCities(){
        return new String[]{"Bothell","Seattle"};
    }

    public int[] getPostalCodes(){
        return new int []{98012, 98007};
    }

    public String getLocalCountryName(Country country){
        return country.toString().substring(0,3);
    }

    public int getCountryCode(Country country){
        return country.ordinal();
    }

    public String[] getStates(Country country){
        return new String[]{"Washington", "California", "Texas"};
    }
}