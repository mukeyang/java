package df;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by CS on 2017/8/26.
 */

    public class test {
        public static void evaluate_dataset(String path) throws IOException {
            Map<String, List<Rating>> map = Files.newBufferedReader(Paths.get(path)).lines().map(Rating::new).collect(Collectors.groupingBy(a -> a.itemId));
            System.out.println("item:"+map.keySet().size());
            System.out.println("count"+map.values().stream().filter(a -> a.size() > 4).count());
            BigDecimal d=new BigDecimal(1);
            d.multiply(d);

        }

        public static void main(String[] args) throws IOException {
            String path="D:/dataset/ratings.csv";
            Instant start = Instant.now();
            evaluate_dataset(path);
            Instant over = Instant.now();
            System.out.println(Duration.between(start,over).getSeconds());

        }
    }
