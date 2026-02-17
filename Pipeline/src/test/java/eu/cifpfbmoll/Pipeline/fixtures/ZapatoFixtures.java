// package eu.cifpfbmoll.Pipeline.fixtures;

// import eu.cifpfbmoll.Pipeline.model.Zapato;
// import eu.cifpfbmoll.Pipeline.repository.ZapatoRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// @Component  // ← Se ejecuta al iniciar la app
// public class ZapatoFixtures implements CommandLineRunner {

//     @Autowired
//     private ZapatoRepository zapatoRepository;

//     @Override
//     public void run(String... args) throws Exception {
//         // Borra datos existentes
//         zapatoRepository.deleteAll();
        
//         // 10+ ZAPATOS de prueba
//         zapatoRepository.save(new Zapato("Nike Air Max 90", 42));
//         zapatoRepository.save(new Zapato("Adidas Ultraboost", 38));
//         zapatoRepository.save(new Zapato("Puma RS-X", 37));
//         zapatoRepository.save(new Zapato("Converse Chuck 70", 39));
//         zapatoRepository.save(new Zapato("Vans Old Skool", 41));
//         zapatoRepository.save(new Zapato("New Balance 574", 43));
//         zapatoRepository.save(new Zapato("Asics Gel-Kayano", 36));
//         zapatoRepository.save(new Zapato("Reebok Classic", 40));
//         zapatoRepository.save(new Zapato("Fila Disruptor", 42));
//         zapatoRepository.save(new Zapato("Skechers Go Walk", 38));
//         zapatoRepository.save(new Zapato("Under Armour HOVR", 44));
//     }
// }
