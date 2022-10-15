package com.webbanhang.jpa.dao;

import com.webbanhang.jpa.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryDao extends JpaRepository<History, Integer> {
}