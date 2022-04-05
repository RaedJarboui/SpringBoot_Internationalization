/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.translate.dto.ColumnsDTO;
import com.translate.entity.Translation;
import com.translate.repository.TranslationRepository;
import com.translate.service.TranslationService;

import lombok.var;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@RestController
@CrossOrigin
public class TranslationController {
	@Autowired
	TranslationService translationService;
	@Autowired
	private SomeDao dao;
	@Autowired
	TranslationRepository translationRepository;
	private static final Logger logger = LogManager.getLogger(TranslationController.class);

	@PutMapping("/translate/edit/{field_value}/{column}/{tableName}")
	@ResponseBody
	public void editTranslation(@PathVariable("field_value") String fieldvalue, @PathVariable("column") String column,
			@PathVariable("tableName") String tableName, @RequestBody Translation translation) {

		translationService.editTranslation(fieldvalue, column, tableName, translation);
	}

	@PostMapping("/translate/add")
	@ResponseBody
	public void addTranslation(@RequestBody Translation translation) {

		translationService.addTranslation(translation);

	}

	@GetMapping("/translate/get")
	@ResponseBody
	public List<Translation> getAllTranslations() {

		return translationService.getAllTranslation();
	}

	@GetMapping("/table/data/{tableName}")
	@ResponseBody
	public List<JSONObject> getTableData(@PathVariable("tableName") String tableName) {

		var l = dao.getTableData(tableName);
		Gson gson = new Gson();
		String jsonUsersSet = gson.toJson(l);
		logger.info("jsonUsersSet: {} ", jsonUsersSet);
		logger.info(l);
		return l;
	}

	@GetMapping("/list/table")
	@ResponseBody
	public List<String> listTable() {

		return translationService.listTables();
	}

	@GetMapping("/column/type/table/{value}")
	@ResponseBody
	public List<String> columnTypeTable(@PathVariable("value") String value) {

		return translationService.columnsTablesType(value);
	}

	@GetMapping("/column/table/{value}")
	@ResponseBody
	public List<String> columnsTable(@PathVariable("value") String value) {

		return translationService.columnsTables(value);
	}

	@GetMapping("/translate/get/{id}")
	@ResponseBody
	public Translation getSingleTranslate(@PathVariable("id") Long id) {

		return translationService.getTranslationById(id);

	}

	@GetMapping("/translate/get/table/{name_table}")
	@ResponseBody
	public String nametypecolumn(@PathVariable("name_table") String nameTable) {

		return translationService.nameTypeColumn(nameTable);

	}

	@GetMapping("/translate/get/table/data/{name_table}/{selected_column}/{Json}")
	@ResponseBody
	public HashMap<Object, Object> nameTypeColumnData(@PathVariable("name_table") String nameTable,
			@PathVariable("selected_column") String selectedColumn, @PathVariable("Json") Boolean json) {

		return translationService.nameColType(nameTable, selectedColumn, json);

	}

	@GetMapping("/translate/get/table/data/json/{name_table}/{selected_column}/{Json}")
	@ResponseBody
	public ResponseEntity<?> nameTypeColumnDataJson(@PathVariable("name_table") String nameTable,
			@PathVariable("selected_column") String selectedColumn, @PathVariable("Json") Boolean json) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(translationService.nameTypeColumnDatajson(nameTable, selectedColumn, json).toString());

	}

	@PostMapping("/translate/get/table/data/json/{name_table}/{selected_column}/{Json}/select1")
	@ResponseBody

	public ResponseEntity<?> select1(@PathVariable("name_table") String nameTable,
			@PathVariable("selected_column") String selectedColumn, @PathVariable("Json") Boolean json,
			@RequestBody String column) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(translationService.select1(nameTable, selectedColumn, json, column).toList());
	}

	@PostMapping("/translate/get/table/data/json/{name_table}/{selected_column}/{Json}/select2")
	@ResponseBody

	public ResponseEntity<HashMap<Object, Object>> select2(@PathVariable("name_table") String nameTable,
			@PathVariable("selected_column") String selectedColumn, @PathVariable("Json") Boolean json,
			@RequestBody ColumnsDTO columns) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(translationService.select2(nameTable, selectedColumn, json, columns));

	}

}
