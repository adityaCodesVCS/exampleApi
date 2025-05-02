package com.exampleApi.service;

import com.exampleApi.entity.Registration;
import com.exampleApi.exception.ResourceNotFound;
import com.exampleApi.payload.RegistrationDto;
import com.exampleApi.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;
    private ModelMapper modelMapper;
    public RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository; //Here we do constructor based DI and not using @Autowired.
        this.modelMapper = modelMapper; //Here we do DI using constructor of modelMapper.
    }


    public RegistrationDto saveRegistration(RegistrationDto registrationDto) {
        //Convert from DTO to Entity & Save the Entity to DB.

//        Registration registration = new Registration();
//        registration.setName(registrationDto.getName());
//        registration.setEmailId(registrationDto.getEmailId());
//        registration.setMobile(registrationDto.getMobile());
                    //OR
        Registration registration = convertDtoToEntity(registrationDto); //Here we call convertDtoToEntity() and it is called by 'this' keyword internally by SB.
        Registration savedReg = registrationRepository.save(registration);
        //Convert from Entity to DTO & return a DTO...

//        RegistrationDto savedRegDto = new RegistrationDto();
//        savedRegDto.setName(savedReg.getName());
//        savedRegDto.setEmailId(savedReg.getEmailId());
//        savedRegDto.setMobile(savedReg.getMobile());
                    //OR
        RegistrationDto savedRegDto = convertEntityToDto(savedReg);
        return savedRegDto;
    }

    Registration convertDtoToEntity (RegistrationDto registrationDto) {
        Registration registration = modelMapper.map(registrationDto, Registration.class); //map(Object source, Object destination)
        return registration;
    }

    RegistrationDto convertEntityToDto(Registration registration) {
        RegistrationDto registrationDto = modelMapper.map(registration, RegistrationDto.class);
        return registrationDto;
    }

    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);
    }

    public void updateRegistration(long id, RegistrationDto registrationDto) {
        //Actual recordById fetched from DB to object-reg.
        Optional<Registration> optReg = registrationRepository.findById(id);
        Registration reg = optReg.get();

        reg.setName(registrationDto.getName());
        reg.setEmailId(registrationDto.getEmailId());
        reg.setMobile(registrationDto.getMobile());
        registrationRepository.save(reg);
    }

    public List<RegistrationDto> getAllRegistration(int pageNo, int pageSize, String sortBy, String sortDir) {

        //Use ternary operator for creating Sort object
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
                                                                  //Sort.by(sortBy) i.e. String sortBy converted to Sort sortBy.
        Pageable page = PageRequest.of(pageNo, pageSize, sort);
        Page<Registration> records = registrationRepository.findAll(page);
        List<Registration> registrations = records.getContent(); //Convert  from Page<Registration> to List<Registration>.
        List<RegistrationDto> registrationDtos = registrations.stream().map(r -> convertEntityToDto(r)).collect(Collectors.toList());

        System.out.println(page.getPageNumber()); //0
        System.out.println(page.getPageSize()); //5
        System.out.println(records.getTotalPages());
        System.out.println(records.getTotalElements());
        System.out.println(records.isFirst()); //true i.e. Is records present in first page?
        System.out.println(records.isLast()); //false i.e. Is records present in last page?
        System.out.println(records.getNumber()); //0 i.e. print records related page number.

        return registrationDtos;
    }

      //1st way to handle exception: try-catch block...
//    public Registration getRegistrationById(long id) {
//        Registration reg = null;
//        try {
//            Optional<Registration> optReg = registrationRepository.findById(id);
//            reg = optReg.get();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null; //i.e. If exception is thrown then it needs to handle by try block So catch block will run & it returns 'null'.
//        }
//        return reg; //If exception isn't thrown then it need not handle by try block So catch block will not run & it returns 'reg' object.
//    }

        //2nd way to handle exception: @ControllerAdvice Class...
        public Registration getRegistrationById(long id) {
//            Optional<Registration> optReg = registrationRepository.findById(id);
//            Registration reg = optReg.get();
//            return reg;

            //If recordById found then it get stored in Entity Object(reg) and return 'reg' Otherwise-
            Registration reg = registrationRepository.findById(id)
                    .orElseThrow(//-If record not found then orElseThrow() method throw this below exception-
                            () -> new ResourceNotFound("Record not found for ID: " + id)
                            /* -and to handle this type of exception, Let's create @ControllerAdvice Class. */
                    );
            return reg;
        }

}
