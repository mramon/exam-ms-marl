package com.gft.exam.ms.marl.data.specification;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gft.exam.ms.marl.dto.CustomerIn;
import com.gft.exam.ms.marl.model.CustomerDetail;

@Component
public class CustomerListSpecification extends BaseSpecification<CustomerDetail, CustomerIn> {

    @Override
    public Specification<CustomerDetail> getFilter(CustomerIn request) {
        return (root, query, cb) -> {
            query.distinct(true);
            
            boolean firstPredicate = true;
            Specification<CustomerDetail> whereSpec = null;
            List<Specification<CustomerDetail>> specList = new ArrayList<Specification<CustomerDetail>>();
            specList.add(customerIdContains(request.getCustomerId()));
            specList.add(fullNameContains(request.getName()));
            specList.add(fullNameContains(request.getPaternalName()));
            specList.add(fullNameContains(request.getMaternalName()));
            
            for(Specification<CustomerDetail> specification : specList) {
            	if(specification != null) {
            		if(firstPredicate) {
            			whereSpec = where(specification);
            			firstPredicate = false;
            		}else {
            			whereSpec.and(specification);
            		}
            	}
			}
            return whereSpec.toPredicate(root, query, cb);
//            return 
//                where(customerIdContains(request.getCustomerId()))
//                     .and(fullNameContains(request.getName()))
//                     .and(fullNameContains(request.getPaternalName()))
//                     .and(fullNameContains(request.getMaternalName()))
//                .toPredicate(root, query, cb);
        };
    }

    private Specification<CustomerDetail> customerIdContains(String customerId) {
        return userAttributeContains("customerId", customerId);
    }
    
    private Specification<CustomerDetail> fullNameContains(String value) {
        return userAttributeContains("fullName", value);
    }

    private Specification<CustomerDetail> userAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(StringUtils.isEmpty(value)) {
                return null;
            	//return cb.isTrue(cb.literal(true));
            }
            return cb.like(
                cb.lower(root.get(attribute)),
                containsLowerCase(value)
            );
        };
    }

}
