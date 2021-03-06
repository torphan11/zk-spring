package example

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.event.Event
import org.zkoss.zk.ui.util.GenericForwardComposer
import org.zkoss.zul.Label
import org.zkoss.zul.Listbox
import org.zkoss.zul.Textbox
import org.apache.log4j.Logger

class PersonCtrl extends GenericForwardComposer {

    private static final String KEY_PEOPLE="KEY_PEOPLE_VIEW_CTRL"

    private static Logger logger = Logger.getLogger(PersonCtrl)

    Listbox personList
    Textbox tbName
    Textbox tbSurname

    PersonService personService
    Person person = new Person()

    @Override
    void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        desktop.setAttribute(KEY_PEOPLE, this);
    }

    void onClick$btnSavePerson(Event e) {
        logger.debug "Saving $person"
		personService.save(person)
		resetForm()
    }

    void onClick$btnNewPerson(Event e) {
        logger.debug "new person"
		resetForm()
    }

	void onClick$btnDeletePerson(Event e) {
		logger.debug "Deleting $person"
		personService.delete(person)
		resetForm()
	}

	void resetForm() {
		person = new Person()
		tbName.text = null
		tbSurname.text = null
		tbName.focus()
	}

}
