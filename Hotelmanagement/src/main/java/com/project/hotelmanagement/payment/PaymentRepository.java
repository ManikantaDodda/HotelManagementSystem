package com.project.hotelmanagement.payment;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	    @Transactional
	    @Modifying
	    @Query("insert into Payment (payment_id,user_name,book_id,amount) select :payment_id,:user_name,:book_id,:amount from Payment")
	    void insertDataintoPayment(@Param("payment_id")Long payment_id,@Param("user_name")String user_name, @Param("book_id")Long book_id, @Param("amount")Long amount);

}
