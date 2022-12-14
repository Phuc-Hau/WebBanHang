package com.webbanhang.service.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.webbanhang.jpa.model.Fluctuation;
import com.webbanhang.service.ConvenientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ConvenientUtils implements ConvenientService {


	@Override
	public String emailToStar(String star) {
		String sao = String.valueOf(star.charAt(0));
		int u = star.indexOf("@") - 1;
		for (int i = 0; i < star.length(); i++) {
			if (i >= u) {
				sao += String.valueOf(star.charAt(i));
			} else
				sao += "*";
		}
		
		return sao;
	}

	@Override
	public String ranDomCapCha() {
		String capChas = "";
		for (int i = 0; i < 6; i++) {
			double randomDouble = Math.random();
			randomDouble = randomDouble * 9 + 1;
			capChas += (int) randomDouble;
		}
		return capChas;
	}

	@Override
	public Fluctuation fluctuation(float last, float next){
		Fluctuation fluctuation = new Fluctuation();
		fluctuation.setTotal((int) last);

		float inDe;

		if(last-next > 0){
			inDe =100- (next/last)*100;
			fluctuation.setRatio("Increased by");
		}else if(last-next <0){
			inDe =100- (last/next)*100;
			fluctuation.setRatio("Decreased by");
		} else{
			inDe = 50;
			fluctuation.setRatio("Equal by");
		}

		if(last==0 || next==0){
			inDe=100;
		}

		fluctuation.setInDe((int) inDe);

		return fluctuation;
	}
	
}
