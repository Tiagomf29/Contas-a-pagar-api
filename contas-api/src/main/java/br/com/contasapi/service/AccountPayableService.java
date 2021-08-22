package br.com.contasapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.contasapi.domain.AccountPayable;
import br.com.contasapi.domain.LaunchAccountPay;
import br.com.contasapi.functions.utils.GenericsFunctions;
import br.com.contasapi.genericsinterfaces.InterfaceGenericsCrud;
import br.com.contasapi.repository.AccountPayableRepository;

@Service
public class AccountPayableService implements InterfaceGenericsCrud<AccountPayable>{

	@Autowired
	AccountPayableRepository accountPayableRespository;
	
	@Override		
	public HashMap<AccountPayable, Integer> insert(AccountPayable t) {
		// Gravando o cabeçalho do contas a pagar
		int lCodigo = accountPayableRespository.save(t).getCode();
		
		// Gravando os lançamentos
		String day, month, year;
		float value;
		day   = String.valueOf(t.getDateFirstPayable().getDayOfMonth());
		month = String.valueOf(t.getDateFirstPayable().getMonthValue());
		year  = String.valueOf(t.getDateFirstPayable().getYear());
		
		if(t.isAmount()) {
			
			value = t.getValue();	
		}else {
			
			value = t.getValue() / t.getQuantityPlots();
		}
		
		for(int i = 0; i < t.getQuantityPlots()-1; i++) {
			
			LocalDate dataParcela = LocalDate.of(Integer.valueOf(year),Integer.valueOf(month), Integer.valueOf(day));
						
			LaunchAccountPay lap = new LaunchAccountPay();
			lap.setAccountPayable(t);
			lap.setDate(dataParcela);
			lap.setParcelInstallment(i+1);
			lap.setValue(value);
			
			LaunchAccountPayService laps = new LaunchAccountPayService();
			laps.insert(lap);
		}
						
		return GenericsFunctions.returnMapByObjects(t,lCodigo);	
	}

	@Override
	public HashMap<AccountPayable, Integer> update(AccountPayable t) {
		
		if(t.getCode() > 0) {	
			
			return GenericsFunctions.returnMapByObjects(t, accountPayableRespository.save(t).getCode());			
		}
	  
		return GenericsFunctions.returnMapByObjects(t, 0);
	}

	@Override
	public ResponseEntity<AccountPayable> delete(int id) {
		accountPayableRespository.deleteById(id);		
		return ResponseEntity.noContent().build();
	}

	@Override
	public ArrayList<AccountPayable> allList() {
		return (ArrayList<AccountPayable>) accountPayableRespository.findAll();
	}

	@Override
	public ArrayList<AccountPayable> listByCod(int id) {
		return (ArrayList<AccountPayable>) accountPayableRespository.findById(id);
	}

}
