package br.com.contasapi.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.TypeIncome;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.service.TypeIncomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/types-income")
@Api(value = "Api Rest de tipo de renda")
@CrossOrigin(origins = "*")
public class TypeIncomeController{

	@Autowired
	TypeIncomeService typeIncomeService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os registros de tipo de renda")
	public ArrayList<TypeIncome> listAllTypesIncome() {
		return typeIncomeService.allList();
	}

	@PostMapping
	@ApiOperation(value = "Insere um novo registro de tipo de renda")
	public ResponseEntity<TypeIncome> insertTypeIncome(@Valid @RequestBody TypeIncome t) {
		return ResponseEntity.ok((TypeIncome) GenericsFunctions.returnObjectByMap(typeIncomeService.insert(t)));
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de tipo de renda")
	public ResponseEntity<TypeIncome> updateTypeIncome(@Valid @RequestBody TypeIncome t) {
		
		TypeIncome newTypeIncome = (TypeIncome) GenericsFunctions.returnObjectByMap(typeIncomeService.update(t));
		
		if(newTypeIncome.getCode() != 0) {
			return ResponseEntity.ok(newTypeIncome);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cod}")
	@ApiOperation(value = "Deleta um registro de tipo de renda")
	public ResponseEntity<TypeIncome> deleteTypeIncome(@PathVariable int cod) {
		return typeIncomeService.delete(cod);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Consulta um registro de tipo de renda por código")
	public ArrayList<TypeIncome> listConsultIdTypeIncome(@PathVariable int id) {
		return typeIncomeService.listByCod(id);
	}

}
