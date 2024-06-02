package model.Repository;

public  interface  BasicCrud{

        Object create(Object object);

        Object update (Object object);

        void delete(Long id);

        Object findById(Object id);

}
