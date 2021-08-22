package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.TypeIncome;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsController;
import br.com.contasapi.service.TypeIncomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/typeIncome")
@Api(value = "Api Rest de tipo de renda")
@CrossOrigin(origins = "*")
public class TypeIncomeController implements InterfaceGenericsController<TypeIncome>{

	@Autowired
	TypeIncomeService typeIncomeService;
	
	@Override
	@ApiOperation(value = "Lista todos os registros de tipo de renda")
	public ArrayList<TypeIncome> listAllController() {
		return typeIncomeService.allList();
	}

	@Override
	@ApiOperation(value = "Insere um novo registro de tipo de renda")
	public ResponseEntity<TypeIncome> insertController(TypeIncome t) {
		return ResponseEntity.ok((TypeIncome) GenericsFunctions.returnObjectByMap(typeIncomeService.insert(t)));
	}

	@Override
	@ApiOperation(value = "Atualiza um registro de tipo de renda")
	public ResponseEntity<TypeIncome> updateController(TypeIncome t) {
		
		TypeIncome newTypeIncome = (TypeIncome) GenericsFunctions.returnObjectByMap(typeIncomeService.update(t));
		
		if(newTypeIncome.getCode() != 0) {
			return ResponseEntity.ok(newTypeIncome);
		}
		
		return ResponseEntity.notFound().build();
	}

	@Override
	@ApiOperation(value = "Deleta um registro de tipo de renda")
	public ResponseEntity<TypeIncome> deleteController(int cod) {
		return typeIncomeService.delete(cod);
	}

	@Override
	@ApiOperation(value = "Consulta um registro de tipo de renda por código")
	public ArrayList<TypeIncome> listConsultIdController(int id) {
		return typeIncomeService.listByCod(id);
	}

}
