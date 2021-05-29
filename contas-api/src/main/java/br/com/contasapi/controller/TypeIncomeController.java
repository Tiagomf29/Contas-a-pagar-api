package br.com.contasapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contasapi.domain.TypeIncome;
import br.com.contasapi.genericsinterfaces.GenericsController;
import br.com.contasapi.service.TypeIncomeService;

@RestController
@RequestMapping("/typeIncome")
public class TypeIncomeController implements GenericsController<TypeIncome>{

	@Autowired
	TypeIncomeService typeIncomeService;
	
	@Override
	public ArrayList<TypeIncome> listAllController() {
		return typeIncomeService.allList();
	}

	@Override
	public ResponseEntity<TypeIncome> insertController(TypeIncome t) {
		return typeIncomeService.insert(t);
	}

	@Override
	public ResponseEntity<TypeIncome> updateController(TypeIncome t) {
		return typeIncomeService.update(t);
	}

	@Override
	public ResponseEntity<TypeIncome> deleteController(int cod) {
		return typeIncomeService.delete(cod);
	}

}
