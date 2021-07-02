package com.stevelee.springmvc.day2_file_session;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevelee.springmvc.day1_data.Person;

@Controller
public class FileController {
	

	
	@RequestMapping(value = "/inputpersonfile")
	public String inputPerson() {
		
		return "day2/inputpersonpost";
	}
	
	@ResponseBody
	@RequestMapping(value = "/inputfilewrite",method = RequestMethod.POST)
	public String inputFileWrite(@RequestBody Person person) throws Exception{
		
		FileWriter fw = new FileWriter(new File("C:\\01_stevelee_academy\\03_step3_springmvc\\workspace\\springmvc\\src\\main\\java\\com\\stevelee\\springmvc\\day2_file_session\\test.txt"),true);
		fw.write(person.toString2() + "\n");
		fw.close();
		
		return "test1";
	}

	
	@RequestMapping(value = "/inputpersonfilelist")
	public String inputPersonList(Model model) throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\01_stevelee_academy\\03_step3_springmvc\\workspace\\springmvc\\src\\main\\java\\com\\stevelee\\springmvc\\day2_file_session\\test.txt"));

		String modelline = "";
		
		while(true) {
			String line = br.readLine();
			if(line == null ||line.isEmpty()) break;
			else modelline +=line +"<br>";
		}
		
		
		
		model.addAttribute("modelline", modelline);
		
		
		return "day2/inputpersonlist";
	}
	
	@RequestMapping(value = "/inputpersonfilelistobject")
	public String inputPersonListObject(Model model) throws Exception{
		
		ArrayList<Person> personlist = new ArrayList<Person>();
		
		System.out.println("aa");
		BufferedReader br = new BufferedReader(new FileReader("C:\\01_stevelee_academy\\03_step3_springmvc\\workspace\\springmvc\\src\\main\\java\\com\\stevelee\\springmvc\\day2_file_session\\test.txt"));

		
		
		String modelline = "";
		
		while(true) {
			
			String line = br.readLine();
			if(line == null ||line.isEmpty()) break;
			else {
				String[] personobjs = line.split(",");
				personlist.add(new Person(personobjs[0], Integer.parseInt(personobjs[1]), personobjs[2]));
			}
			
		}
		
		System.out.println("count:" + personlist.size());
		
		model.addAttribute("personlist", personlist);
		
		
		return "day2/inputpersonlistobjs";
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/inputfileremove",method = RequestMethod.POST)
	public boolean inputfileremove(@RequestBody String index) throws Exception{
		
		System.out.println("index:" + index);
		
		ArrayList<Person> personlist = new ArrayList<Person>();
		
		System.out.println("aa");
		BufferedReader br = new BufferedReader(new FileReader("C:\\01_stevelee_academy\\03_step3_springmvc\\workspace\\springmvc\\src\\main\\java\\com\\stevelee\\springmvc\\day2_file_session\\test.txt"));

		
		
		String modelline = "";
		
		while(true) {
			
			String line = br.readLine();
			if(line == null ||line.isEmpty()) break;
			else {
				String[] personobjs = line.split(",");
				personlist.add(new Person(personobjs[0], Integer.parseInt(personobjs[1]), personobjs[2]));
			}
			
		}
		
		FileWriter fw = new FileWriter(new File("C:\\01_stevelee_academy\\03_step3_springmvc\\workspace\\springmvc\\src\\main\\java\\com\\stevelee\\springmvc\\day2_file_session\\test.txt"));
		
		int indexnum = Integer.parseInt(index);
		
		boolean result = false;
		
		for(int num = 0 ; num < personlist.size(); num++) {
			
			if(num == indexnum) {
				personlist.remove(num);
				result = true;
				break;
			}
			
		}
		
		System.out.println("size:" + personlist.size());
		
		for(Person item:personlist) {
			fw.write(item.toString2() + "\n");			
		}
		

		fw.close();
		
		return result;
	}

}
