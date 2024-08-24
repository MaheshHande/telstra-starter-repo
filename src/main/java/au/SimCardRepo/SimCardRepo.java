package au.SimCardRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.telstra.Entity.SimCardRequest;

public interface SimCardRepo extends JpaRepository<SimCardRequest , Long > {



}
