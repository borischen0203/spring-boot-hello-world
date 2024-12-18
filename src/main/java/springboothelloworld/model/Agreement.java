package springboothelloworld.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@Getter
@NoArgsConstructor(force = true)
@ToString
@Entity
public class Agreement {
    @Id
    private final int agreementId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int agreementReviewId;
    private final String agreementTitle;
    private final String userName;
    private final String userAccount;
}
