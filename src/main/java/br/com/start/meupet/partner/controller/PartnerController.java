package br.com.start.meupet.partner.controller;

import br.com.start.meupet.partner.dto.PartnerRequestDTO;
import br.com.start.meupet.partner.dto.PartnerResponseDTO;
import br.com.start.meupet.partner.repository.PartnerRepository;
import br.com.start.meupet.partner.service.PartnerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/partner")
@CrossOrigin
public class PartnerController {

    private static final Logger log = LoggerFactory.getLogger(PartnerController.class);

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public ResponseEntity<List<PartnerResponseDTO>> listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int items) {
//        List<Partner> partners = List.of(
//                new Partner("Parceiro 1", new Email("parceiro1@example.com"), new PersonalRegistration("69736371000131", DocumentType.CNPJ), "senhaSegura123", new PhoneNumber("(11) 12 98765-4321")),
//                new Partner("Parceiro 2", new Email("parceiro2@example.com"), new PersonalRegistration("69736371000132", DocumentType.CNPJ), "senhaSegura456", new PhoneNumber("(21) 23 91234-5678")),
//                new Partner("Parceiro 3", new Email("parceiro3@example.com"), new PersonalRegistration("98272930011", DocumentType.CPF), "senhaSegura789", new PhoneNumber("(31) 23 99876-5432")),
//                new Partner("Parceiro 4", new Email("parceiro4@example.com"), new PersonalRegistration("98272930012", DocumentType.CPF), "senhaSegura012", new PhoneNumber("(41) 23 91234-5678")),
//                new Partner("Parceiro 5", new Email("parceiro5@example.com"), new PersonalRegistration("98272930013", DocumentType.CPF), "senhaSegura345", new PhoneNumber("(51) 23 98765-4321")),
//                new Partner("Parceiro 6", new Email("parceiro6@example.com"), new PersonalRegistration("69736371000133", DocumentType.CNPJ), "senhaSegura678", new PhoneNumber("(61) 32 99876-5432")),
//                new Partner("Parceiro 7", new Email("parceiro7@example.com"), new PersonalRegistration("98272930014", DocumentType.CPF), "senhaSegura901", new PhoneNumber("(71) 23 91234-5678")),
//                new Partner("Parceiro 8", new Email("parceiro8@example.com"), new PersonalRegistration("69736371000134", DocumentType.CNPJ), "senhaSegura234", new PhoneNumber("(81) 23 98765-4321")),
//                new Partner("Parceiro 9", new Email("parceiro9@example.com"), new PersonalRegistration("98272930015", DocumentType.CPF), "senhaSegura567", new PhoneNumber("(91) 23 99876-5432")),
//                new Partner("Parceiro 10", new Email("parceiro10@example.com"), new PersonalRegistration("69736371000135", DocumentType.CNPJ), "senhaSegura890", new PhoneNumber("(99) 23 91234-5678"))
//        );
//
//// Salvar todos os parceiros no repositório
//        partnerRepository.saveAll(partners);
        log.info("Requisicao GET: listando todos os parceiros");
        return ResponseEntity.ok(partnerService.listAll(page, items));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerResponseDTO> listOne(@PathVariable UUID id) {
        log.info("Requisicao GET: listando um parceiros");
        PartnerResponseDTO partnerResponse = partnerService.getPartnerById(id);
        return ResponseEntity.ok().body(partnerResponse);
    }

    @PostMapping
    public ResponseEntity<PartnerResponseDTO> insertNewUser(@RequestBody @Valid PartnerRequestDTO partnerRequest) {
        PartnerResponseDTO partnerResponse = partnerService.insert(partnerRequest);
        log.info("Requisicao POST: inserindo um novo parceiro - {}", partnerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(partnerResponse);
    }

    @PutMapping
    public ResponseEntity<PartnerResponseDTO> update(@RequestParam UUID id, @RequestBody @Valid PartnerRequestDTO newPartner) {
        PartnerResponseDTO updatedPartner = partnerService.update(id, newPartner);
        log.info("Requisicao PUT: atualizando um parceiro já existente - {}", newPartner.toString());
        return ResponseEntity.ok().body(updatedPartner);
    }

    // http://localhost:8080/partner?id=3
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        partnerService.delete(id);
        log.info("Requisicao DELETE: deletando um parceiro");
        return ResponseEntity.noContent().build();
    }


}
