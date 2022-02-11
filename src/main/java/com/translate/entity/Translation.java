/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Entity
@Table(name = "translation")
@TypeDef(name = "json", typeClass = JsonStringType.class)

public class Translation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7602179343085972411L;
	@Id
	@GeneratedValue
	@Column(name = "product_translation_id")
	public Long id;
	@Column(name = "name_table")
	private String name_table;
	@Column(name = "object_id")
	private Long object_id;
	@Column(name = "selected_column")
	private String selected_column;
	@Type(type = "json")
	@Column(columnDefinition = "json")
	private List<Langues> translations;

	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * @JoinColumn(name = "translation") private List<Langues> translations = new ArrayList<>();
	 */

	/**
	 * @return the translations
	 */
	public List<Langues> getTranslations() {

		return translations;
	}

	/**
	 * @param translations the translations to set
	 */
	public void setTranslations(List<Langues> translations) {

		this.translations = translations;
	}

	/**
	 * @return the selected_column
	 */
	public String getSelected_column() {

		return selected_column;
	}

	/**
	 * @param selected_column the selected_column to set
	 */
	public void setSelected_column(String selected_column) {

		this.selected_column = selected_column;
	}

	/**
	 * @return the id
	 */
	public Long getId() {

		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * @return the name_table
	 */
	public String getName_table() {

		return name_table;
	}

	/**
	 * @param name_table the name_table to set
	 */
	public void setName_table(String name_table) {

		this.name_table = name_table;
	}

	/**
	 * @return the object_id
	 */
	public Long getObject_id() {

		return object_id;
	}

	/**
	 * @param object_id the object_id to set
	 */
	public void setObject_id(Long object_id) {

		this.object_id = object_id;
	}

}
