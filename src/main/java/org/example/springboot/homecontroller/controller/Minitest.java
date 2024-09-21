package org.example.springboot.homecontroller.controller;

import org.example.springboot.model.minitest.Province;
import org.example.springboot.model.minitest.ResponseObject;
import org.example.springboot.model.minitest.Student;
import org.example.springboot.model.minitest.TourResponse;
import org.example.springboot.services.minitest.MiniTestProvinceService;
import org.example.springboot.services.minitest.MinitestService;
import org.example.springboot.services.minitest.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/minitest")
public class Minitest {
    @Autowired
    private StudentService studentService;


    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private MinitestService minitest2Service;
    @Autowired
    MiniTestProvinceService minitest2ProvinceService;

    //        @GetMapping("/showTour")
//    public ModelAndView showTour(@RequestParam(defaultValue = "10") int page,
//                                 @RequestParam(defaultValue = "3") int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "code"));
//        Page<Tour2> tour2Page = minitest2Service.tour2Page(pageable);
//        ModelAndView modelAndView = new ModelAndView("listMinitest2");
//        modelAndView.addObject("tour2", tour2Page.getContent());
//        modelAndView.addObject("currentPage", tour2Page.getNumber());
//        modelAndView.addObject("totalPages", tour2Page.getTotalPages());
//        modelAndView.addObject("size", size);
//        return modelAndView;
//    }
//    @GetMapping
//    List<Tour> getAllProducts() {
//        return minitest2Service.listTour();
//    }
    @GetMapping
    public ResponseEntity<?> showTour(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "100") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "phone"));
        Page<Student> tourPage = minitest2Service.tourPage(pageable);

        TourResponse response = new TourResponse();
        response.setTours(tourPage.getContent());
        response.setCurrentPage(tourPage.getNumber());
        response.setTotalPages(tourPage.getTotalPages());
        response.setSize(tourPage.getSize());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id) {
        Optional<Student> tour2 = Optional.ofNullable(minitest2Service.findById(id));
        return tour2.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Successfully", tour2))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> addTour(@RequestBody Student student) {
        if (student.getProvince() != null) {
            Province province = minitest2ProvinceService.findById(student.getProvince().getId());
            if (province != null) {
                student.setProvince(province);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("error", "Province not found", "not found"));
            }
        }

        minitest2Service.saveTour(student);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Successfully updated", student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseObject> deleteTour(@PathVariable int id) {
        Optional<Student> tour2Optional = Optional.ofNullable(minitest2Service.findById(id));
        if (tour2Optional.isPresent()) {
            Student student2Exist = tour2Optional.get();
            minitest2Service.deleteTour(student2Exist.getId());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Successfully deleted", "ok", student2Exist));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("error", "Not Found", "not found"));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateTour(@PathVariable int id, @RequestBody Student student2) {
        Optional<Student> tour2Optional = Optional.ofNullable(minitest2Service.findById(id));
        if (tour2Optional.isPresent()) {
            Student student2Exist = tour2Optional.get();
            student2Exist.setName(student2.getName());
            student2Exist.setPhone(student2.getPhone());
            student2Exist.setGmail(student2.getGmail());

            if (student2.getProvince() != null) {
                Province province = minitest2ProvinceService.findById(student2.getProvince().getId());
                if (province != null) {
                    student2Exist.setProvince(province);
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("error", "Province not found", "not found"));
                }
            }

            minitest2Service.saveTour(student2Exist);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Successfully updated", student2Exist));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseObject> searchStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone) {
        List<Student> students = studentService.findStudents(name, email, phone);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Successfully updated", studentService.findStudents(name, email, phone)));

    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ResponseObject> deleteProvince(@PathVariable int id) {
//        Province province = minitest2ProvinceService.findById(id);
//        if (province != null) {
//            minitest2ProvinceService.removeById(id);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Successfully updated", province));
//    }
//
//    @GetMapping("/province")
//    List<ProvinceDTO> getAllProvince() {
//        return minitest2ProvinceService.listProvinceDTOs();
//    }


//    @GetMapping("/create")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("addTour2");
//        modelAndView.addObject("tourForm2", new TourForm2());
//        modelAndView.addObject("provinces", minitest2ProvinceService.provinceDTOs());
//        return modelAndView;
//    }
//
//    @PostMapping("/save")
//    public String saveProduct(@ModelAttribute TourForm2 tourForm2) {
//        MultipartFile multipartFile = tourForm2.getImg();
//        String fileName = multipartFile != null ? multipartFile.getOriginalFilename() : "";
//        try {
//            if (multipartFile != null) {
//                assert fileName != null;
//                if (!fileName.isEmpty()) {
//                    FileCopyUtils.copy(tourForm2.getImg().getBytes(), new File(fileUpload + fileName));
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        Tour2 tour2 = new Tour2(tourForm2.getId(), tourForm2.getCode(),
//                tourForm2.getDestination(), tourForm2.getStart(), fileName);
//        minitest2Service.saveTour(tour2);
//
//        return "redirect:/minitest2/showTour";
//    }

//    @GetMapping("/delete/{id}")
//    public String deleteTour(@PathVariable("id") int id) {
//        minitest2Service.deleteTour(id);
//        return "redirect:/minitest2/showTour";
//    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showUpdateForm(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("editTour2");
//        Tour2 tour2 = minitest2Service.getTourById(id);
//        TourForm2 tourForm2 = new TourForm2(tour2.getId(), tour2.getCode(), tour2.getDestination(), tour2.getStart(), null);
//        modelAndView.addObject("tour2", tourForm2);
//        return modelAndView;
//    }
//
//    @PostMapping("/edit/update/{id}")
//    public String editTour(@ModelAttribute TourForm2 tourForm2, @PathVariable("id") int id) {
//        MultipartFile file = tourForm2.getImg();
//        String fileName = file != null ? file.getOriginalFilename() : "";
//        try {
//            if (file != null) {
//                assert fileName != null;
//                if (!fileName.isEmpty()) {
//                    FileCopyUtils.copy(tourForm2.getImg().getBytes(), new File(fileUpload + fileName));
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        Tour2 tour2 = new Tour2(tourForm2.getId(), tourForm2.getCode(),
//                tourForm2.getDestination(), tourForm2.getStart(), fileName);
//        minitest2Service.updateTour(tour2);
//
//        return "redirect:/minitest2/showTour";
//    }


}


//    @GetMapping("/search")
//    public ModelAndView searchBlogs(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
//        Page<Tour2> tour2Page = minitest2Service.searchTour(query, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "code")));
//        ModelAndView modelAndView = new ModelAndView("listMinitest2");
//        modelAndView.addObject("tour2", tour2Page.getContent());
//        modelAndView.addObject("currentPage", tour2Page.getNumber());
//        modelAndView.addObject("totalPages", tour2Page.getTotalPages());
//        modelAndView.addObject("size", size);
//        modelAndView.addObject("query", query);
//        return modelAndView;
//    }
//}
