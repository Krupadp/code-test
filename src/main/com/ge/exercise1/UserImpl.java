package com.ge.exercise1;

public class UserImpl extends User{

	public UserImpl(String id, String name) {
		super(id, name);
	}
	@Override
    public int hashCode() {
        return super.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User))
            return false;

        User mdc = (User) obj;
        return mdc.getId().equals(super.getId());
    }

}
