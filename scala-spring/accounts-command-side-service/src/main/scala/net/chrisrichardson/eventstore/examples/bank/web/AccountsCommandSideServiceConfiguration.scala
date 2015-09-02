package net.chrisrichardson.eventstore.examples.bank.web

import net.chrisrichardson.eventstore.client.config.EventStoreHttpClientConfiguration
import net.chrisrichardson.eventstore.examples.bank.web.accounts.CommandSideWebAccountsConfiguration
import net.chrisrichardson.eventstore.json.EventStoreCommonObjectMapping
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.context.annotation._
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

@Configuration
@EnableAutoConfiguration
@Import(Array(classOf[CommandSideWebAccountsConfiguration], classOf[EventStoreHttpClientConfiguration]))
@ComponentScan
class AccountsCommandSideServiceConfiguration {

  @Bean
  def scalaJSonConverter: HttpMessageConverters = {
    val additional  = new MappingJackson2HttpMessageConverter
    additional.setObjectMapper(EventStoreCommonObjectMapping.getObjectMapper)
    new HttpMessageConverters(additional)
  }


}
