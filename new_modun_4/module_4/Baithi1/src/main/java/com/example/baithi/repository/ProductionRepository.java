package com.example.baithi.repository;

import com.example.baithi.dto.ProductionDto;
import com.example.baithi.model.Production;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductionRepository extends JpaRepository<Production, Integer> {

    @Query(value = "SELECT \n" +
            "pd.name_production AS nameProduction,\n" +
            "pd.poit AS poit,\n" +
            "np.number AS number,\n" +
            "np.star_day AS startDay,\n" +
            "FROM\n" +
            " production pd\n" +
            "        LEFT JOIN\n" +
            "    type_production tp ON pd.id_production = tp.id_type_production\n" +
            "        LEFT JOIN\n" +
            "   number_production np ON pd.id_production = np.id_number_production\n" +
            "GROUP BY pd.id_production",
            nativeQuery = true, countQuery = "select count(*) from production")
    Page<ProductionDto>  showListProduction(Pageable pageable);
}
