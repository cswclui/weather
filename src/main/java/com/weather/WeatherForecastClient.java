interface WeatherService {
    int getTemperature();
}

class HKWeatherService implements WeatherService { //extends the WeatherService
    String weatherAPIUrl;
    String apiKey;
    public HKWeatherService(String weatherAPIUrl, String apiKey) {
        this.weatherAPIUrl=weatherAPIUrl;
        this.apiKey=apiKey;
        System.out.println("Connect to Hong Kong weather service: "+weatherAPIUrl);
    }

    //get the temperature from a weather API
    public int getTemperature() {
        return 30; //to be implemented
    }
}

class MacauWeatherService implements WeatherService { //extends the WeatherService
    String weatherAPIUrl;
    String apiKey;    
    public MacauWeatherService(String weatherAPIUrl, String apiKey) {
        this.weatherAPIUrl=weatherAPIUrl;
        this.apiKey=apiKey;
        System.out.println("Connect to Macau weather service: "+weatherAPIUrl);
    }

    //get the temperature from a weather API
    public int getTemperature() {
        return 30; //to be implemented
    }
}

class WeatherForecastService  {
    private WeatherService weatherService;
    String location;
    String serviceUrl;
    String apiKey;

    //define the constructor
    public WeatherForecastService(String location, String serviceUrl, String apiKey) {
        this.location = location;
        this.serviceUrl = serviceUrl;
        this.apiKey = apiKey;
    }

    public String getWeatherInfo() {
        if (location.equals("Hong Kong")){
            this.weatherService= new HKWeatherService(serviceUrl, apiKey);
        }
        else if (location.equals("Macau")) {
            this.weatherService = new MacauWeatherService(serviceUrl, apiKey);
        }
        else { //not support
            return "Location Not Supported!";
        }   
        
        int temperature = weatherService.getTemperature();
        if (temperature > 30) {
            return "The weather is hot. The temperature is "+temperature;
        } else if (temperature > 20) {
            return "The weather is warm. The temperature is "+temperature;
        } else if (temperature > 10) {
            return "The weather is cool. The temperature is "+temperature;
        } else {
            return "The weather is cold. The temperature is "+temperature;
        }
    }
}

public class WeatherForecastClient 
{
    public static void main( String[] args ) throws Exception
    {
        WeatherForecastService f1 = new WeatherForecastService(
            "Hong Kong","http://hkweather-service/v1/weather","12345678");
        System.out.println( f1.getWeatherInfo());

        WeatherForecastService f2 = new WeatherForecastService(
            "Macau","http://macauweather-service/v1/temperature","87654321");
        System.out.println( f2.getWeatherInfo() );
    }
}

