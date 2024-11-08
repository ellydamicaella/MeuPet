package br.com.start.meupet.domain.interfaces;

import br.com.start.meupet.domain.valueobjects.Email;
import br.com.start.meupet.domain.valueobjects.PhoneNumber;

public interface Authenticable {

    Number getId();

    String getName();

    Email getEmail();

    String getPassword();

    PhoneNumber getPhoneNumber();
}
