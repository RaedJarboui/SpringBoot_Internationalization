/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.entity.TableList;
import com.translate.repository.TableListRepository;
import com.translate.repository.TranslationRepository;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class TableListService {
	@Autowired
	TableListRepository tableListRepository;
	@Autowired
	TranslationRepository translationRepository;

	public List<String> ListTable() {

		return translationRepository.TablesList();
	}

	public List<TableList> ListTables() {

		return tableListRepository.findAll();
	}

	public void addListTable(List<TableList> l) {

		tableListRepository.saveAll(l);

	}

	public List<TableList> TableList() {

		List<TableList> list_tabList = tableListRepository.findAll();
		List<String> tableNameStrings = translationRepository.TablesList();
		boolean boolval = false;
		for (TableList tab : list_tabList) {
			for (String table : tableNameStrings) {
				boolval = tab.getTableName().equals(table);

			}

		}
		if (boolval == false) {
			System.out.println("false");
			for (String table : tableNameStrings) {
				TableList tableList = new TableList(table, false);
				list_tabList.add(tableList);
				tableListRepository.save(tableList);
			}

		}
		else {
			System.out.println("true");
			return null;

		}

		return list_tabList;

	}

	public TableList editTableList(int id, TableList t) {

		TableList tab = tableListRepository.findById(id).get();
		tab.setTableName(t.getTableName());
		tab.setTranslate(t.getTranslate());
		return tableListRepository.save(tab);
	}
}
