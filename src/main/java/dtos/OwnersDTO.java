package dtos;

import entities.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnersDTO {

    List<OwnerDTO> owners = new ArrayList();

    public OwnersDTO(List<Owner> ownerEntity) {
        ownerEntity.forEach((o) -> {
            owners.add(new OwnerDTO(o));
        });
    }

    public List<OwnerDTO> getAll() {

        return owners;
    }

    @Override
    public String toString() {
        return "OwnersDTO{" +
                "owners=" + owners +
                '}';
    }
}
