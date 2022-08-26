package br.sub.com.projectmodel.shared.components;

import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppJwtTokenEnhancer implements TokenEnhancer {

  @Autowired
  private UserRepository repository;

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    User entity = repository.findByEmail(authentication.getName());
    Map<String, Object> addInfoToken = new HashMap<>();
    addInfoToken.put("userId", entity.getId());
    addInfoToken.put("userFistName", entity.getFirstName());
    addInfoToken.put("userLastName", entity.getLastName());

    DefaultOAuth2AccessToken inforTokenUser = (DefaultOAuth2AccessToken) accessToken;
    inforTokenUser.setAdditionalInformation(addInfoToken);
    return accessToken;
  }
}
