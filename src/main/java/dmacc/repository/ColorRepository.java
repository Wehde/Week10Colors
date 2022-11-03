/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Nov 1, 2022
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.HexColor;

public interface ColorRepository extends JpaRepository<HexColor, String>{

}
