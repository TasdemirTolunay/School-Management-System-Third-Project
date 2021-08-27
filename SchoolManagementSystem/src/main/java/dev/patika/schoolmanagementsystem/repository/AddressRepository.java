package dev.patika.schoolmanagementsystem.repository;

import dev.patika.schoolmanagementsystem.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

    List<Address> findByCountry(String countryName);
    List<Address> findByCity(String cityName);
    List<Address> findByPlateCode(String pC);

}
