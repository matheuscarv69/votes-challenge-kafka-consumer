package resultsconsumer.entities.results.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("Quantidade de Votos Sim")
    private Integer yesQuantity;

    @ApiModelProperty("Quantidade de Votos Não")
    private Integer noQuantity;

    public Results(Integer yesQuantity, Integer noQuantity) {
        this.yesQuantity = yesQuantity;
        this.noQuantity = noQuantity;
    }

    // only hibernate
    public Results() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYesQuantity() {
        return yesQuantity;
    }

    public void setYesQuantity(Integer yesQuantity) {
        this.yesQuantity = yesQuantity;
    }

    public Integer getNoQuantity() {
        return noQuantity;
    }

    public void setNoQuantity(Integer noQuantity) {
        this.noQuantity = noQuantity;
    }
}
