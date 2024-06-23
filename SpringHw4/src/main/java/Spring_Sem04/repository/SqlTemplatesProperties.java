package Spring_Sem04.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "sql")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SqlTemplatesProperties {
    private String sqlFindAll;
    private String sqlSave;
    private String sqlDeleteById;
    private String sqlUpdateUser;
    private String sqlGetOne;
}
