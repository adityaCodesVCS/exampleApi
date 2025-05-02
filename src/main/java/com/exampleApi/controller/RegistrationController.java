package com.exampleApi.controller;

import com.exampleApi.entity.Registration;
import com.exampleApi.payload.RegistrationDto;
import com.exampleApi.service.RegistrationService;
import jakarta.servlet.ServletOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@RestController
@RequestMapping("/api/v1/registration") //this is URI(Uniform Resource Identifier).
public class RegistrationController {

    private RegistrationService registrationService;
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /*  http://localhost:8080/api/v1/registration --> this is URL(Uniform Resource Locator).
                                                      When I run this URL, addRegistration() method will call.  */
    //ResponseEntity<T>(BuiltIn Class) used to return for an HTTP response with both data of type-T and an HTTP status code.
    @PostMapping //Use to save/send/post data in DB when this method called.
    public ResponseEntity<RegistrationDto> addRegistration(@RequestBody RegistrationDto registrationDto) {
        RegistrationDto regDto = registrationService.saveRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED); /* i.e. return an object of ResponseEntity class which
                                    contains variable regDto's data of type RegistrationDto and HTTP status code. */
    }

      //1st way of delete record -> By Query Parameter
//    /*  http://localhost:8080/api/v1/registration?id=1 --> Query Parameter(?id=1)  */
//    @DeleteMapping //Use for delete data from DB.
//    public String deleteRegistration(
//            @RequestParam long id /*  Parameters(id) taken from the URL and makes as variables in method.
//                                      Variable name(id) should match with parameter-name(id) of URL.  */
//    ) {
//        registrationService.deleteRegistration(id);
//        return "Deleted";
//    }

    //2nd way of delete record -> By Path Parameter
    /*  http://localhost:8080/api/v1/registration/2 --> Path Parameter(/2)  */
    @DeleteMapping("/{id}") /*  http://localhost:8080/api/v1/registration/{id} --> {id}=2 */
    public String deleteRegistration(
            @PathVariable long id /*  Parameter value taken from the URL and makes as variable value in method through /{id} of @DeleteMapping("/{id}").
                                      Variable name(id) should match with parameter-name(id) of @DeleteMapping("/{id}").  */
    ) {
        registrationService.deleteRegistration(id);
        return "Deleted";
    }

    /* Here we are directly copying data into Entity Class But we can
       also do by Putting data into payload(DTO) which I have to update. */
    /*  http://localhost:8080/api/v1/registration/4  */
    @PutMapping("/{id}") //Use for update data in DB.
    public ResponseEntity<RegistrationDto> updateRegistration( //Actual data should be updated by incoming JSON data from POSTMAN.
            @PathVariable long id,
            @RequestBody RegistrationDto registrationDto //Incoming JSON data will store in this object-registration.
    ) {
        registrationService.updateRegistration(id, registrationDto);
        return new ResponseEntity<>(registrationDto, HttpStatus.OK);
    }

    /*  http://localhost:8080/api/v1/registration?pageNo=0&pageSize=5&sortBy=name&sortDir=asc  */
    @GetMapping //Use for read/get/retrieve data from DB.
    public ResponseEntity<List<RegistrationDto>> getAllRegistration(
            @RequestParam(defaultValue = "0", required = false) int pageNo,
            @RequestParam(defaultValue = "5", required = false) int pageSize,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = "asc", required = false) String sortDir //It can be optional because it's always in ascending by default.
    ) {
        List<RegistrationDto> registrationDtos = registrationService.getAllRegistration(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(registrationDtos, HttpStatus.OK);
        /* @GetMapping annotation convert this List<RegistrationDto>'s java object into JSON
           object which shown in POSTMAN when this method called. */
    }

    //1st way to handle exception: try-catch block.
    /*  http://localhost:8080/api/v1/registration/id/5  */
    /* Here this method might be return two type of value(Registration type & String type) --> Never seen this type of scenario earlier than-
       -Let's make return type of this method as dynamic(?/Object). */
//    @GetMapping("/id/{id}") /*  http://localhost:8080/api/v1/registration/id/{id} --> {id}=5  */
//    public ResponseEntity<?> getRegistrationById(
//            @PathVariable long id
//    ) {
//        Registration registration = registrationService.getRegistrationById(id);
//        if(registration != null) { //i.e. getRegistrationById() return 'reg' object which get stored in 'registration' variable
//            return new ResponseEntity<>(registration, HttpStatus.OK); /* i.e. return an object of ResponseEntity class which
//                                    contains variable registration's data of type Registration and HTTP status code. */
//        }
//        //Otherwise(if(registration == null)), it'll return this...
//        return new ResponseEntity<>("No Record Found for id: "+id, HttpStatus.NOT_FOUND); /* i.e. return an object of ResponseEntity
//                                        class which contains "message" of type String and HTTP status code. */
//    }

    /*  http://localhost:8080/api/v1/registration/id/25  */
    @GetMapping("/id/{id}") /*  http://localhost:8080/api/v1/registration/id/{id} --> {id}=25  */
    public ResponseEntity<Registration> getRegistrationById(
            @PathVariable long id
    ) throws FileNotFoundException { //Here this FileNotFoundException thrown to @ControllerAdvice's class by 'throws' keyword & been handled there.
        FileReader fr = new FileReader("C:\\test.txt"); //Here we get CompileTime/Checked(FileNotFoundException) Exception.
        Registration registration = registrationService.getRegistrationById(id);
        return new ResponseEntity<>(registration, HttpStatus.OK);
    }


}
