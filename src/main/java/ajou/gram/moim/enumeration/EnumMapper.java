package ajou.gram.moim.enumeration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnumMapper {
    private Map<String, List<EnumValue>> factory = new HashMap<>();

    public List<EnumValue> toEnumValues(Class<? extends EnumInterface> e){
        return Arrays
                .stream(e.getEnumConstants())
                .map(EnumValue::new)
                .collect(Collectors.toList());
    }

    public void put(String key, Class<? extends EnumInterface> e){
        factory.put(key, toEnumValues(e));
    }

    public Map<String, List<EnumValue>> getAll(){
        return factory;
    }

    public Map<String, List<EnumValue>> get(String keys){
        return Arrays
                .stream(keys.split(","))
                .collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
    }
}
