package dev.patika.schoolmanagementsystem.service;

import dev.patika.schoolmanagementsystem.entity.Address;
import dev.patika.schoolmanagementsystem.entity.Instructor;
import dev.patika.schoolmanagementsystem.entity.Student;
import dev.patika.schoolmanagementsystem.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService implements ServiceRepository<Address> {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {

        List<Address> addressList = new ArrayList<>();
        Iterable<Address> addressIterable = addressRepository.findAll();
        addressIterable.iterator().forEachRemaining(addressList :: add);
        return addressList;

    }

    @Override
    public Address findById(int id) {

        return addressRepository.findById(id).get();

    }

    @Override
    @Transactional
    public Address save(Address address) {

        return addressRepository.save(address);

    }

    @Override
    @Transactional
    public Address update(Address address, int id) {

        Address findAddress = findById(id);
        findAddress.setCity(address.getCity());
        findAddress.setCountry(address.getCountry());
        findAddress.setPlateCode(address.getPlateCode());
        return addressRepository.save(findAddress);

    }

    @Override
    @Transactional
    public String deleteById(int id) {

        addressRepository.deleteById(id);
        return "Address id = " + id + " Deleted....";
    }

    @Override
    @Transactional
    public String deleteObject(Address address) {

        addressRepository.delete(address);
        return "Address Deleted......";

    }

    public List<Address> findAddressByCountry(String country){

        return addressRepository.findByCountry(country);

    }

    public List<Address> findAddressByCity(String city){

        return addressRepository.findByCity(city);

    }

    public List<Address> findAddressByPlateCode(String plateCode){

        return addressRepository.findByPlateCode(plateCode);

    }

    public List<Student> studentsOfAddress(int id){

        return findById(id).getStudentList();

    }

    public List<Instructor> instructorOfAddress(int id){

        return findById(id).getInstructorList();

    }

}
