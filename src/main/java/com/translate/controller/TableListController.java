/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.translate.dto.TableListPaginationDTO;
import com.translate.entity.TableList;
import com.translate.service.TableListService;

/**
 * {@link } class.
 *
 * @author Mr Raed
 * @since 0.1.0
 */
@RestController
@CrossOrigin
public class TableListController {
	@Autowired
	TableListService tableListService;

	@GetMapping("list/tables/paginate")
	@ResponseBody
	public List<TableList> listTablesPaginated(@RequestParam int page, @RequestParam int size) {

		return tableListService.listTablesPaginated(page, size);
	}

	@GetMapping("list/tables")
	@ResponseBody
	public List<String> getTablesList() {

		return tableListService.listTable();
	}

	@GetMapping("list/tablesfromdb")
	@ResponseBody
	public List<TableList> getTablesListFromDB() {

		return tableListService.listTablesFromDB();
	}

	@PostMapping("list/tables")
	@ResponseBody
	public void addTablesList(@RequestBody List<TableList> l) {

		tableListService.addListTable(l);
	}

	@PutMapping("list/tables/{id}")
	@ResponseBody
	public void addTablesList(@PathVariable("id") int id, @RequestBody TableList TableList) {

		tableListService.editTableList(id, TableList);
	}

	@PostMapping("/list/tables/find")
	@ResponseBody
	public TableListPaginationDTO find(@RequestBody TableListPaginationDTO tableListPaginationDTO) {
		return tableListService.find(tableListPaginationDTO);
	}

	@PostMapping("list/tables/new")
	@ResponseBody
	public List<TableList> tableList() {

		return tableListService.tableList();
	}

}
