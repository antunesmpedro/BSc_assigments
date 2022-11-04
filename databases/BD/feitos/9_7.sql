select distinct first_name, last_name from customer, rental, inventory,store  
       where customer.customer_id=rental.customer_id and 
       	     rental.inventory_id=inventory.inventory_id and 
	     inventory.store_id = store.store_id and 
	     store.country=customer.country
	     order by 1,2;
       	     