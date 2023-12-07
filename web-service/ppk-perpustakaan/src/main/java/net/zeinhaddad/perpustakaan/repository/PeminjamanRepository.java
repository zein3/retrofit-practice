package net.zeinhaddad.perpustakaan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.zeinhaddad.perpustakaan.entity.Peminjaman;


@RepositoryRestResource(collectionResourceRel = "peminjaman", path = "peminjaman")
public interface PeminjamanRepository extends
    PagingAndSortingRepository<Peminjaman, Long>,
    CrudRepository<Peminjaman, Long> {
    
}
