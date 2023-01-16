package com.control.epp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.control.epp.entity.Salida;
public interface SalidaRepository extends JpaRepository<Salida, Long>{
	public List<Salida> findOneByColaborador(String dni);
	
	
	@Query(
			value = "select \r\n"
					+ "	des_patrimonio, \r\n"
					+ "	cantidad,\r\n"
					+ "	um_patrimonio,\r\n"
					+ "	fecha, \r\n"
					+ "	tipo\r\n"
					+ "	from salida_patrimonio com\r\n"
					+ "	inner join colaborador rsc ON rsc.id = colaborador_id\r\n"
					+ "	INNER join patrimonio rsp ON rsp.id = patrimonio_id\r\n"
					+ "	where (select colaborador.id from colaborador \r\n"
					+ "		   where :dniColaborador = dni_colaborador) = patrimonio_id\r\n"
					+ "	order by fecha desc;", nativeQuery = true)
	List<Salida> nativo(@Param("dniColaborador") String dniColaborador);
		
	
	@Query(value = "select * from listar_Registro_Dni(:dniColaborador);", nativeQuery = true)
	List<?> listDni(@Param("dniColaborador") String dniColaborador);
	
	
}
