package kz.roxy.tsoed;

import kz.roxy.tsoed.restservice.client.SynergyRSClient;
import kz.roxy.tsoed.restservice.domain.synergy.AsformsDataData;
import kz.roxy.tsoed.restservice.domain.synergy.AsformsDataResponse;
import kz.roxy.tsoed.restservice.domain.synergy.AsformsDataSaveResponse;
import kz.roxy.tsoed.restservice.domain.synergy.CreateDocResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SynergyRSClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SynergyRSClientTest.class);

    @Autowired
    private SynergyRSClient synergyRSClient;

    @Test
    @Ignore
    public void сreateDocTest() throws Exception {

        CreateDocResponse response = synergyRSClient.callRegistryCreateDoc();

        if (response == null) {
            throw new TsoedException("createDocResponse is null");
        }
        LOGGER.info("response: getErrorCode = {}, getDocumentID = {}, getAsfNodeID = {}, getDataUUID = {}",
                response.getErrorCode(), response.getDocumentID(), response.getAsfNodeID(), response.getDataUUID());
    }

    @Test
    @Ignore
    public void callAsformsDataTest() throws Exception {

        String dataUUID = "8cece052-ceb3-454e-8972-73025a929096";

        AsformsDataResponse response = synergyRSClient.callAsformsData(dataUUID);

        if (response == null) {
            throw new TsoedException("asformsDataResponse is null");
        }
        LOGGER.info("response: getForm = {}; getFormVersion = {}; getUuid = {}; getData.size = {}", response.getForm(), response.getFormVersion(), response.getUuid(), response.getData().size());
    }

    @Test
    public void callAsformsDataSaveTest() throws Exception {
        String uuid =
                "8cece052-ceb3-454e-8972-73025a929096";


        String dataJson = "[{\"id\":\"cmp-2xa8m1\",\"type\":\"label\",\"label\":\"Код корреспондента отправителя\"},{\"id\":\"correspondent_from\",\"type\":\"listbox\",\"value\":\"Аббревиатура (рус)\",\"key\":\"Код\"},{\"id\":\"cmp-371692\",\"type\":\"label\",\"label\":\"Код корреспондента отправителя\"},{\"id\":\"correspondent_from_kz\",\"type\":\"listbox\",\"value\":\"Название (рус)\",\"key\":\"Код\"},{\"id\":\"cmp-pbx52s\",\"type\":\"label\",\"label\":\"Множество Код корреспондента кому\"},{\"id\":\"performers\",\"type\":\"listbox\",\"value\":\"Название (рус)\",\"key\":\"Код\"},{\"id\":\"cmp-twksgu\",\"type\":\"label\",\"label\":\"Множество Код корреспондента кому\"},{\"id\":\"performers_kz\",\"type\":\"listbox\",\"value\":\"Название (рус)\",\"key\":\"Код\"},{\"id\":\"cmp-jyg52a\",\"type\":\"label\",\"label\":\"guid документа\"},{\"id\":\"documentid\",\"type\":\"textbox\",\"value\":\"guid документа\"},{\"id\":\"cmp-kb1m07\",\"type\":\"label\",\"label\":\"Код корреспондента отправителя\"},{\"id\":\"from\",\"type\":\"textbox\",\"value\":\"Код корреспондента отправителя\"},{\"id\":\"cmp-3glkbo\",\"type\":\"label\",\"label\":\"Время отправки из СЭД\"},{\"id\":\"doclog_send_time\",\"type\":\"textbox\",\"value\":\"Время отправки из СЭД\"},{\"id\":\"cmp-36ysj0\",\"type\":\"label\",\"label\":\"Номер исходящего документа\"},{\"id\":\"outgoing_number\",\"type\":\"textbox\",\"value\":\"Номер исходящего документа\"},{\"id\":\"cmp-a2irck\",\"type\":\"label\",\"label\":\"Дата исходящего документа\"},{\"id\":\"outgoing_date\",\"type\":\"date\",\"value\":\"29-12-2017\",\"key\":\"2017-12-29 00:00:00\"},{\"id\":\"cmp-sknd33\",\"type\":\"label\",\"label\":\"Автор\"},{\"id\":\"author\",\"type\":\"textbox\",\"value\":\"Автор\"},{\"id\":\"cmp-p38cwg\",\"type\":\"label\",\"label\":\"Автор(каз)\"},{\"id\":\"author_kz\",\"type\":\"textbox\",\"value\":\"Автор(каз)\"},{\"id\":\"cmp-wbua78\",\"type\":\"label\",\"label\":\"Исполнитель\"},{\"id\":\"performer\",\"type\":\"textbox\",\"value\":\"Исполнитель\"},{\"id\":\"cmp-ckwkjs\",\"type\":\"label\",\"label\":\"Исполнитель(каз)\"},{\"id\":\"performer_kz\",\"type\":\"textbox\",\"value\":\"Исполнитель(каз)\"},{\"id\":\"cmp-u1cqfo\",\"type\":\"label\",\"label\":\"Телефон исполнителя\"},{\"id\":\"performer_phone\",\"type\":\"textbox\",\"value\":\"Телефон исполнителя\"},{\"id\":\"cmp-peq1n5\",\"type\":\"label\",\"label\":\"Язык документа\"},{\"id\":\"document_lang\",\"type\":\"textbox\",\"value\":\"Язык документа\"},{\"id\":\"cmp-dlxe7i\",\"type\":\"label\",\"label\":\"Форма документа\"},{\"id\":\"document_form\",\"type\":\"textbox\",\"value\":\"Форма документа\"},{\"id\":\"cmp-1qe0qu\",\"type\":\"label\",\"label\":\"Код внешнего типа контроля\"},{\"id\":\"control_type_code\",\"type\":\"textbox\",\"value\":\"Код внешнего типа контроля\"},{\"id\":\"cmp-l783o6\",\"type\":\"label\",\"label\":\"Внешний тип контроля\"},{\"id\":\"control_type\",\"type\":\"textbox\",\"value\":\"Внешний тип контроля\"},{\"id\":\"cmp-tg6dz6\",\"type\":\"label\",\"label\":\"Внешний тип контроля(Каз)\"},{\"id\":\"control_type_kz\",\"type\":\"textbox\",\"value\":\"Внешний тип контроля(Каз)\"},{\"id\":\"cmp-weppnx\",\"type\":\"label\",\"label\":\"Внешний срок исполнения\"},{\"id\":\"external_deadline\",\"type\":\"textbox\",\"value\":\"Внешний срок исполнения\"},{\"id\":\"cmp-a7qw1q\",\"type\":\"label\",\"label\":\"Должность\"},{\"id\":\"rank\",\"type\":\"textbox\",\"value\":\"Должность\"},{\"id\":\"cmp-fkk1x8\",\"type\":\"label\",\"label\":\"Должность(Каз)\"},{\"id\":\"rank_kz\",\"type\":\"textbox\",\"value\":\"Должность(Каз)\"},{\"id\":\"cmp-5f2i6i\",\"type\":\"label\",\"label\":\"Способ доставки\"},{\"id\":\"delivery_method\",\"type\":\"textbox\",\"value\":\"Способ доставки\"},{\"id\":\"cmp-46ehh5\",\"type\":\"label\",\"label\":\"Листов\"},{\"id\":\"page\",\"type\":\"numericinput\",\"value\":\"4\",\"key\":\"4\"},{\"id\":\"cmp-j3dw5x\",\"type\":\"label\",\"label\":\"Приложений\"},{\"id\":\"app\",\"type\":\"numericinput\",\"value\":\"4\",\"key\":\"4\"},{\"id\":\"cmp-0dxi9x\",\"type\":\"label\",\"label\":\"Экземпляров\"},{\"id\":\"copy\",\"type\":\"numericinput\",\"value\":\"4\",\"key\":\"4\"},{\"id\":\"cmp-2y14z2\",\"type\":\"label\",\"label\":\"Код тип документа\"},{\"id\":\"document_type_esedoid\",\"type\":\"textbox\",\"value\":\"Код тип документа\"},{\"id\":\"cmp-hzpdcf\",\"type\":\"label\",\"label\":\"Код тип документа\"},{\"id\":\"document_type_esedoid_kz\",\"type\":\"textbox\",\"value\":\"Код тип документа\"},{\"id\":\"cmp-wx24zp\",\"type\":\"label\",\"label\":\"Код характера вопроса\"},{\"id\":\"question_type_esedoid\",\"type\":\"textbox\",\"value\":\"Код характера вопроса\"},{\"id\":\"cmp-atpuxp\",\"type\":\"label\",\"label\":\"Код характера вопроса\"},{\"id\":\"question_type_esedoid_kz\",\"type\":\"textbox\",\"value\":\"Код характера вопроса\"},{\"id\":\"cmp-o65u7f\",\"type\":\"label\",\"label\":\"Краткое содержание\"},{\"id\":\"content\",\"type\":\"textbox\",\"value\":\"Краткое содержание\"},{\"id\":\"cmp-4vc8jl\",\"type\":\"label\",\"label\":\"Ссылки на вложения\"},{\"id\":\"attachments\",\"type\":\"filelink\",\"value\":\"\"},{\"id\":\"cmp-g7yhj8\",\"type\":\"label\",\"label\":\"Не подписываемые вложения\"},{\"id\":\"attachments2\",\"type\":\"filelink\",\"value\":\"\"},{\"id\":\"cmp-0jtalu\",\"type\":\"label\",\"label\":\"Подписи канцелярии\"},{\"id\":\"kanc_sign\",\"type\":\"listbox\"},{\"id\":\"cmp-jgtaix\",\"type\":\"label\",\"label\":\"Подписи руководителя\"},{\"id\":\"ruk_sign\",\"type\":\"listbox\"},{\"id\":\"cmp-9e81u2\",\"type\":\"label\",\"label\":\"Является ответным на\"},{\"id\":\"answer\",\"type\":\"listbox\"},{\"id\":\"cmp-rqs78i\",\"type\":\"label\",\"label\":\"На номер\"},{\"id\":\"docToNumber\",\"type\":\"textbox\",\"value\":\"На номер\"},{\"id\":\"cmp-9k3j7b\",\"type\":\"label\",\"label\":\"Имя подписывающего\"},{\"id\":\"signerName\",\"type\":\"textbox\",\"value\":\"Имя подписывающего\"},{\"id\":\"cmp-cklxkd\",\"type\":\"label\",\"label\":\"Имя подписывающего(Каз)\"},{\"id\":\"signerNameKz\",\"type\":\"textbox\",\"value\":\"Имя подписывающего(Каз)\"},{\"id\":\"cmp-rfdej9\",\"type\":\"label\",\"label\":\"Дата подготовки к отправке\"},{\"id\":\"preparedDate\",\"type\":\"date\"},{\"id\":\"cmp-dm8vf2\",\"type\":\"label\",\"label\":\"Содержание(Самрук)\"},{\"id\":\"note\",\"type\":\"textbox\",\"value\":\"Содержание(Самрук)\"},{\"id\":\"cmp-jpgnzj\",\"type\":\"label\",\"label\":\"Текст резолюции(Самрук)\"},{\"id\":\"resolution\",\"type\":\"textbox\",\"value\":\"Текст резолюции(Самрук)\"},{\"id\":\"cmp-yb3j6q\",\"type\":\"label\",\"label\":\"ФИО получателя(Самрук)\"},{\"id\":\"receiver_fio_ru\",\"type\":\"textbox\",\"value\":\"ФИО получателя(Самрук)\"},{\"id\":\"cmp-nfq7lk\",\"type\":\"label\",\"label\":\"Требует ответа(1\\\\0) (Самрук)\"},{\"id\":\"request_answer\",\"type\":\"textbox\",\"value\":\"Требует ответа(1\\\\0) (Самрук)\"},{\"id\":\"cmp-5xf3qf\",\"type\":\"label\",\"label\":\"ИД пункта\"},{\"id\":\"sectionId\",\"type\":\"textbox\",\"value\":\"ИД пункта\"},{\"id\":\"cmp-w9tatb\",\"type\":\"label\",\"label\":\"userUin(ПЭП)\"},{\"id\":\"userUin\",\"type\":\"textbox\",\"value\":\"userUin(ПЭП)\"},{\"id\":\"cmp-fo2vuw\",\"type\":\"label\",\"label\":\"idPortalInternal(ПЭП)\"},{\"id\":\"idPortalInternal\",\"type\":\"textbox\",\"value\":\"idPortalInternal(ПЭП)\"},{\"id\":\"cmp-ot18pa\",\"type\":\"label\",\"label\":\"Номер основного документа\"},{\"id\":\"docNoR\",\"type\":\"textbox\",\"value\":\"Номер основного документа\"},{\"id\":\"cmp-y6shl3\",\"type\":\"label\",\"label\":\"ФИО получателя КЗ\"},{\"id\":\"documentReceiverKz\",\"type\":\"textbox\",\"value\":\"ФИО получателя КЗ\"}]";
        JSONArray jsonArray = new JSONArray(dataJson);

        List<AsformsDataData> asformsDataDataList = new ArrayList();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            AsformsDataData asformsDataData = new AsformsDataData();

            asformsDataData.setId(explrObject.optString("id"));
            asformsDataData.setKey(explrObject.optString("key"));
            asformsDataData.setLabel(explrObject.optString("label"));
            asformsDataData.setType(explrObject.optString("type"));
            asformsDataData.setValue(explrObject.optString("value"));

            asformsDataDataList.add(asformsDataData);
        }

        AsformsDataSaveResponse response = synergyRSClient.callAsformsDataSave(
                uuid,
                asformsDataDataList
        );

        if (response == null) {
            throw new TsoedException("response is null");
        }
        LOGGER.info("response: {}",  response);
    }



}
