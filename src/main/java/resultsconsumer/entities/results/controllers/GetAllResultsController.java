package resultsconsumer.entities.results.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resultsconsumer.entities.results.entity.Results;
import resultsconsumer.entities.results.repositories.ResultsRepository;

import java.util.List;

@Api(tags = "Resultados")
@RestController
@RequestMapping("/results")
public class GetAllResultsController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResultsRepository repository;

    @ApiOperation("Busca resultados de todas as Votações")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @GetMapping
    public ResponseEntity<List<Results>> getAllResults() {
        log.info("Receiving request for get all results");


        List<Results> results = repository.findAll();


        return ResponseEntity.ok().body(results);
    }


}
