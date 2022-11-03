/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 30, 2022
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Palette;

@Repository
public interface PaletteRepository extends JpaRepository<Palette, Long>{

}
